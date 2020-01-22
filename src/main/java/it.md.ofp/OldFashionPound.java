package it.md.ofp;

public class OldFashionPound {

    public static void main(String[] args) {
        try {
            // PARSE
            RawOperationParser parser = new RawOperationParser(args);
            OldPound op_1 = parser.parseLeftPound();
            OldPound op_2 = parser.parseRightPound();
            OfpArithmeticEnum operator = parser.parseOperator();
            // SETUP OPERATION
            OfpBasicArithmetic basicArithmetic = BasicArithmeticFactory.getBasicArithmetic(operator);
            OfpOperation operation = new OfpOperation(op_1, op_2, basicArithmetic);
            // CALCULATE
            OldPound result = operation.calculate();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}