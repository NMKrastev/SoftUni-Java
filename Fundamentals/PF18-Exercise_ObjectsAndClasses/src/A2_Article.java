public class A2_Article {

    private String title;
    private String content;
    private String author;

    public A2_Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s",this.title,this.content,this.author);
    }

    public void renameTitle(String titleToRename) {
        this.title = titleToRename;
    }

    public void editContent(String contentToEdit) {
        this.content = contentToEdit;
    }

    public void changeAuthor(String authorToChange) {
        this.author = authorToChange;
    }
}
