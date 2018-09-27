public class Test{
    public static void main(String[] args){
        Word word = new Word();
        DictionaryCommandline listWord = new DictionaryCommandline();
        DictionaryManagement management = new DictionaryManagement();
        management.insertFromCommandline(word);
        listWord.setWord(word);
        listWord.setWord(word);
        listWord.setWord(word);
	listWord.setWord(word);
        listWord.showAllWords();
    }
}