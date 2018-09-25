public class DictionaryCommandline extends Dictionary{
    public void showAllWords(){
        int length = this.list.size();
        int i=0;
        for(i=0; i<length; i++){
            this.showWord(i);
        }
    }
    public void showWord(int index){
        System.out.print(list.get(index).getWordTarget());
        System.out.print("      ");
        System.out.print(list.get(index).getWordExplain());
        System.out.println("   ");
    }
}