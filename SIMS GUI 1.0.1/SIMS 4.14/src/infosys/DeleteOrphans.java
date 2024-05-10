package infosys;

import java.util.Stack;

public class DeleteOrphans {
    Stack<Assignment> orphans;
    public DeleteOrphans(Stack<Assignment> orphans) {
        this.orphans = orphans;
        
    }
    
    // delete all orphans in the Stack
    public void delete() {
        while (!orphans.isEmpty()) {
            new DeleteAssignment(orphans.pop()).delete();
        }
    }
}
