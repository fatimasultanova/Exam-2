package service.inter;

import model.Word;

public interface FileServicInter {
    public Word[] readFile();
    public boolean writeFile(Word word);

}
