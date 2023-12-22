package assignment2;

public class ActionQueue extends MyQueue<Direction> {
    private MyStack<String> stringStack;
    private String K;
    private String D;
    private int left = 0;
    private int right = 0;
    private String result = "";
    private int leftPos = -1;
    private int rightPos = -1;

    public ActionQueue() {
        super();
        this.stringStack = new MyStack<String>();
        this.K = "";
        this.D = "";
    }

    public void clear() {
        this.stringStack.clear();
        super.clear();
        this.K = "";
        this.D = "";
        this.left = 0;
        this.right = 0;
        this.result = "";
        this.leftPos = -1;
        this.rightPos = -1;
    }

    private String simpleDecoder(String simpleK, String simpleD) {
        if (Integer.parseInt(simpleK) == 0) {
            throw new IllegalArgumentException();
        }
        String simpleString = "";
        for (int i = 0; i < Integer.parseInt(simpleK); i++) {
            simpleString += simpleD;
        }
        return simpleString;
    }

    private String extracter(String unextracted) {
        int rightBr = -1;
        int leftBr = -1;
        int numcount = 0;
        for (int i = 0; i < unextracted.length(); i++) {
            boolean reachedleft = false;
            boolean shouldcontinue = true;
            char c = unextracted.charAt(i);
            if (c == ']') {
                rightBr = i;
                for (int j = rightBr; j >= 0; j--) {
                    if (unextracted.charAt(j) == '[' && !reachedleft) {
                        leftBr = j;
                        reachedleft = true;
                    } else if (!reachedleft && j != i) {
                        this.D = unextracted.charAt(j) + this.D;
                    } else if (shouldcontinue) {
                        if (Character.isDigit(unextracted.charAt(j))) {
                            numcount++;
                            this.K = unextracted.charAt(j) + this.K;
                            if (j != 0 && Character.isDigit(unextracted.charAt(j - 1))) {
                                shouldcontinue = true;
                            } else {
                                shouldcontinue = false;
                            }
                        }
                    }
                }
            }
            if (reachedleft) {
                break;
            }
        }
        this.result = "";
        for (int i = 0; i < unextracted.length(); i++) {
            if (i < leftBr - numcount || i > rightBr) {
                this.result += unextracted.charAt(i);
            } else if (i == leftBr) {
                this.result += this.simpleDecoder(this.K, this.D);
            }
        }
        return this.result;
    }

    public void loadFromEncodedString(String inputString) {
        this.clear();
        if (inputString.equals("") || inputString.equals("[]")) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c == '[') {
                if ((i == 0 || i == inputString.length() - 1) || (!(Character.isDigit(inputString.charAt(i - 1))))) {
                    throw new IllegalArgumentException();
                }
                if (!((inputString.charAt(i + 1) == 'N') || (inputString.charAt(i + 1) == 'S') || (inputString.charAt(i + 1) == 'W') || (inputString.charAt(i + 1) == 'E') || (Character.isDigit(inputString.charAt(i + 1))))) {
                    throw new IllegalArgumentException();
                }
                if ((inputString.length() != 1) && (i != inputString.length() - 1) && (inputString.charAt(i + 1) == ']')) {
                    throw new IllegalArgumentException();
                }
                left++;
            } else if (c == ']') {
                if ((i == 0) || (!((inputString.charAt(i - 1) == ']') || (inputString.charAt(i - 1) == 'N') || (inputString.charAt(i - 1) == 'S') || (inputString.charAt(i - 1) == 'W') || (inputString.charAt(i - 1) == 'E')))) {
                    throw new IllegalArgumentException();
                }
                if (i != inputString.length() - 1 && inputString.charAt(i + 1) == '[') {
                    throw new IllegalArgumentException();
                }
                right++;
            } else if (Character.isDigit(c)) {
                if (i == inputString.length() - 1) {
                    throw new IllegalArgumentException();
                }
                if (!((i != inputString.length() - 1) && (inputString.charAt(i + 1) == '[' || Character.isDigit(inputString.charAt(i + 1))))) {
                    throw new IllegalArgumentException();
                }
            } else if (c == 'N' || c == 'S' || c == 'W' || c == 'E') {
                if (i != 0) {
                    if (!((inputString.charAt(i - 1) == 'N') || (inputString.charAt(i - 1) == 'S') || (inputString.charAt(i - 1) == 'W') || (inputString.charAt(i - 1) == 'E') || (inputString.charAt(i - 1) == '[') || (inputString.charAt(i - 1) == ']') || (Character.isDigit(inputString.charAt(i + 1))))) {
                        throw new IllegalArgumentException();
                    }
                }
                if (i != inputString.length() - 1) {
                    if (!((inputString.charAt(i + 1) == 'N') || (inputString.charAt(i + 1) == 'S') || (inputString.charAt(i + 1) == 'W') || (inputString.charAt(i + 1) == 'E') || (inputString.charAt(i + 1) == ']') || (Character.isDigit(inputString.charAt(i + 1))))) {
                        throw new IllegalArgumentException();
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
            if (right > left) {
                throw new IllegalArgumentException();
            }
        }
        if (left != right) {
            throw new IllegalArgumentException();
        }

        String tempStr = inputString;

        if (left == 0) {
            tempStr = inputString;
        } else {
            int counter = left;
            while (counter > 0) {
                tempStr = this.extracter(tempStr);
                this.clear();
                counter--;
            }
        }
        String decodedString = tempStr;

        for (int i = 0; i < decodedString.length(); i++) {
            char decoded = decodedString.charAt(i);
            if (decoded == 'N') {
                this.enqueue(Direction.NORTH);
            } else if (decoded == 'S') {
                this.enqueue(Direction.SOUTH);
            } else if (decoded == 'E') {
                this.enqueue(Direction.EAST);
            } else if (decoded == 'W') {
                this.enqueue(Direction.WEST);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
