package org.example.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class OSDependent implements TestRule {
    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                RunOn env = description.getAnnotation(RunOn.class);
                if(env == null || canEvalate(env.value())){
                    base.evaluate();
                }else{
                    // don't evalate
                }
            }
        };
    }

    private boolean canEvalate(RunOn.OS os){
        String osName = System.getProperty("os.name");
        if(osName == null){
            return false;
        }

        if(os == RunOn.OS.WINDOWS && osName.startsWith("Windows")){
            return true;
        }
        if(os == RunOn.OS.MAC && osName.startsWith("Mac OS X")){
            return true;
        }
        if(os == RunOn.OS.LINUX && osName.startsWith("Linux")){
            return true;
        }

        return false;
    }
}
