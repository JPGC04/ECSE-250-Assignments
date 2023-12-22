package assignment2;

public class TargetQueue extends MyQueue<Position> {
    private MyStack<String> stringStack;

    public TargetQueue() {
        super();
        this.stringStack = new MyStack<String>();
    }

    public void clear() {
        this.stringStack.clear();
        super.clear();
    }

    public void addTargets(String inputString) {
        this.clear();
        if (inputString.equals("")) {
            throw new IllegalArgumentException();
        }
        String num = "";
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c == '(') {
                if ((!(this.stringStack.isEmpty() && num.length() == 0)) || (i != 0 && (!((inputString.charAt(i - 1)) == '.'))) || (i == inputString.length() - 1) || (!(Character.isDigit(inputString.charAt(i + 1))))) {
                    throw new IllegalArgumentException();
                }
                this.stringStack.push("(");
            } else if (Character.isDigit(c)) {
                if (i == 0 || i == inputString.length() - 1) {
                    throw new IllegalArgumentException();
                }
                num += c;
            } else if (c == ',') {
                if ((i == 0) || (num.length() == 0) || (i == inputString.length() - 1) || (!((Character.isDigit(inputString.charAt(i + 1))) && (Character.isDigit(inputString.charAt(i - 1)))))) {
                    throw new IllegalArgumentException();
                }
                this.stringStack.push(num);
                this.stringStack.push(",");
                num = "";
            } else if (c == ')') {
                if ((i == 0) || (!(Character.isDigit(inputString.charAt(i - 1)))) || ((i != inputString.length() - 1) && (inputString.charAt(i + 1) != '.')) || (this.stringStack.getSize() != 3 || num.length() == 0)) {
                    throw new IllegalArgumentException();
                }
                String comma = this.stringStack.pop();
                String otherNum = this.stringStack.pop();
                String parenth = this.stringStack.pop();
                if (!(comma.equals(",") && parenth.equals("("))) {
                    throw new IllegalArgumentException();
                }
                try {
                    int xTemp = Integer.parseInt(otherNum);
                    int yTemp = Integer.parseInt(num);
                    if (this.enqueue(new Position(xTemp, yTemp))) {
                        num = "";
                    }
                } catch (NumberFormatException exception) {
                    throw new IllegalArgumentException();
                }
            } else if (c == '.') {
                if (i == 0 && i != inputString.length() - 1) {
                    if (!(inputString.charAt(i + 1) == '(')) {
                        throw new IllegalArgumentException();
                    }
                } else if (i != 0 && i == inputString.length() - 1) {
                    if (!(inputString.charAt(i - 1) == ')')) {
                        throw new IllegalArgumentException();
                    }
                } else if (i != 0 && i != inputString.length() - 1) {
                    if ((!(inputString.charAt(i - 1) == ')')) || (!(inputString.charAt(i + 1) == '('))) {
                        throw new IllegalArgumentException();
                    }
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        if (!(this.stringStack.isEmpty() && num.length() == 0)) {
            throw new IllegalArgumentException();
        }
    }
}
