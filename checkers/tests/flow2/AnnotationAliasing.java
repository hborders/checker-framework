import checkers.util.test.*;

import java.util.*;
import checkers.quals.*;
import tests.util.*;

// Disable the test.  The Checker Framework behaves correctly, but the
// compiler issues a warning because the test uses a deprecated class
// (checkers.nullness.quals.Pure), and this warning makes the test fail.
// @skip-test
/** Various tests for annotation aliasing. */
class AnnotationAliasing {
    
    String f1, f2, f3;
    
    @Pure int pure1() { return 1; };
    @checkers.nullness.quals.Pure int pure2() { return 1; };
    
    // a method that is not pure (no annotation)
    void nonpure() {
    }
    
    //:: error: (pure.not.deterministic.and.sideeffect.free)
    @Pure String t1() {
      nonpure();
      return "";
    }
    
    //:: error: (pure.not.deterministic.and.sideeffect.free)
    @checkers.nullness.quals.Pure String t2() {
      nonpure();
      return "";
    }
    
    // check aliasing of Pure
    void t1(@Odd String p1, String p2) {
        f1 = p1;
        @Odd String l2 = f1;
        pure1();
        @Odd String l3 = f1;
        pure2();
        @Odd String l4 = f1;
    }
}
