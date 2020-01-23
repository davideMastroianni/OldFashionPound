package it.md.ofp;

import it.md.ofp.basicArithmetic.BasicArithmeticFactory;
import it.md.ofp.basicArithmetic.OfpArithmeticEnum;
import it.md.ofp.basicArithmetic.OfpBasicArithmetic;

public class PriceArithmetic {

    public static void main(String[] args) {
        String result = calculateExpressionFromStandardInput(args);
        System.out.println(result);
    }

    public static String calculateExpressionFromStandardInput(String[] args) {
        // PARSE
        RawOperationParser parser = new RawOperationParser(args);
        try {
            parser.parse();
            OfpArithmeticEnum operator = parser.getOperator();
            OfpBasicArithmetic basicArithmetic;
            if (operator == OfpArithmeticEnum.DIFF || operator == OfpArithmeticEnum.SUM) {
                basicArithmetic = BasicArithmeticFactory.getBasicArithmetic(operator, parser.getLeftOperation(), parser.getRightOperationPound());
            } else {
                basicArithmetic = BasicArithmeticFactory.getBasicArithmetic(operator, parser.getLeftOperation(), parser.getRightOperationInteger());
            }
            OfpOperation operation = new OfpOperation(basicArithmetic);
            // CALCULATE
            OldPound result = operation.calculate();
            return result.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static OldPound calc(OfpArithmeticEnum operator, OldPound op_1, OldPound op_2) throws Exception {
        OfpBasicArithmetic basicArithmetic = BasicArithmeticFactory.getBasicArithmetic(operator, op_1, op_2);
        OfpOperation operation = new OfpOperation(basicArithmetic);
        return operation.calculate();
    }

    public static OldPound calc(OfpArithmeticEnum operator, OldPound op_1, int op_2) throws Exception {
        OfpBasicArithmetic basicArithmetic = BasicArithmeticFactory.getBasicArithmetic(operator, op_1, op_2);
        OfpOperation operation = new OfpOperation(basicArithmetic);
        return operation.calculate();
    }

}