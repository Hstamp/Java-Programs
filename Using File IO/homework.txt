public class TextBook extends Book {
    
    protected String publisher;

    public TextBook(String isbn, String title, String author, String publisher) {

        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;

    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void printPublisher() {
        System.out.println("Publisher: " + publisher);
    }

    public String toString() {
        return ("'" + this.title + "' by " + this.author + ", published by " + this.publisher + ".");
    }

    public void printAllDetails()
    {
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Publisher: " + this.publisher);
    }

}
