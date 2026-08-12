public class TextNormailzer{
    public static String normalizeAndValidate(String input) {
        if (input == null) {
            return "EMPTY_STRING";
        }

        // 1. Remove leading/trailing whitespace using trim() and strip()
        String trimmed = input.trim();
        String cleaned = trimmed.strip();

        // 2. Check if string is empty
        if (cleaned.isEmpty()) {
            return "EMPTY_STRING";
        }
        if (cleaned.equalsIgnoreCase("admin") || cleaned.toLowerCase().equals("admin")) {
            return "RESERVED_WORD";
        }
        String replaced = cleaned.replace("_", " ");

        // 5. Check if string starts with "temp" and ends with "user" (case-insensitive)
        String lowerCaseStr = replaced.toLowerCase();
        if (lowerCaseStr.startsWith("temp") && lowerCaseStr.endsWith("user")) {
            return replaced.concat("_FLAGGED");
        }
        return replaced;
    }
    public static void main(String[] args) {
        String[] testCases = {
            "temp_John_user",
            "  ADMIN  ",
            "   ",
            "  hello_world  "
        };
        for (String test : testCases) {
            System.out.println("Input  : \"" + test + "\"");
            System.out.println("Output : \"" + normalizeAndValidate(test) + "\"\n");
        }
    }
}