package it.md.ofp;

import it.md.ofp.basicArithmetic.OfpBasicArithmetic;

class OfpOperation {

    private OfpBasicArithmetic basicArithmetic;

    OfpOperation(OfpBasicArithmetic basicArithmetic) {
        this.basicArithmetic = basicArithmetic;
    }

    OldPound calculate() {
        return this.basicArithmetic.calculate();
    }
}
