package checkers.value;

import checkers.basetype.BaseTypeChecker;
import checkers.basetype.BaseTypeVisitor;

/**
 * @author plvines
 * 
 *         TODO
 * 
 */
public class ValueVisitor extends BaseTypeVisitor<ValueAnnotatedTypeFactory> {

    public ValueVisitor(BaseTypeChecker checker) {
        super(checker);
    }

    @Override
    protected ValueAnnotatedTypeFactory createTypeFactory() {
        return new ValueAnnotatedTypeFactory(checker);
    }

}
