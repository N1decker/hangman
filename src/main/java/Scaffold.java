public enum Scaffold {

    ZERO {
        @Override
        public String toString() {
            return """
                    __________
                    |      |
                    |     \s
                    |     \s
                    |
                    |
                    __________
                    """;
        }
    },
    ONE {
        @Override
        public String toString() {
            return """
                    __________
                    |      |
                    |      〇
                    |     \s
                    |
                    |
                    __________
                    """;
        }
    },
    TWO {
        @Override
        public String toString() {
            return """
                    __________
                    |      |
                    |      〇/
                    |      |
                    |
                    |
                    __________
                    """;
        }
    },
    THREE {
        @Override
        public String toString() {
            return """
                    __________
                    |     |
                    |    \\〇/
                    |     |
                    |
                    |
                    __________
                    """;
        }
    },
    FOUR {
        @Override
        public String toString() {
            return """
                    __________
                    |     |
                    |    \\〇/
                    |     |
                    |      \\
                    |
                    __________
                    """;
        }
    },
    FIVE {
        @Override
        public String toString() {
            return """
                    __________
                    |     |
                    |    \\〇/
                    |     |
                    |    / \\
                    |
                    __________
                    """;
        }
    },
    SIX {
        @Override
        public String toString() {
            return """
                    __________
                    |      |
                    |      ⊗
                    |     /|\\
                    |     / \\
                    |
                    __________
                    """;
        }
    }
}
