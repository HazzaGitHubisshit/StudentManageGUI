package infosys;

/*
Follows similar principles to StudentID.
*/

public class PaperCode {
    
    public String paperCode;
    
    public PaperCode(String paperCode) {
        if (paperCode != null) {
            this.paperCode = paperCode;
            for (Paper paper : new ManagePapers().getPapers()) {
                if (paper.getPaperCode().toLowerCase().contains(paperCode.toLowerCase())) {
                    this.paperCode = null;
                }
            }
        } else {
            this.paperCode = paperCode;
        }
    }
    
    @Override
    public String toString() {
        return this.paperCode;
    }
}
