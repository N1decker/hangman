public enum Scaffold {

    ZERO {
        @Override
        public String toString() {
            return """
                    __________
                    |      |
                    |      
                    |      
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
                    |      ○
                    |      
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
                    |      ○/
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
                    |      |
                    |    \\○/
                    |      |
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
                    |      |
                    |    \\○/
                    |      |
                    |       \\
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
                    |      |
                    |    \\○/
                    |      |
                    |     / \\
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
