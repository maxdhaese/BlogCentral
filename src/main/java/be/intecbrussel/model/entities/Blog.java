package be.intecbrussel.model.entities;

import be.intecbrussel.model.EntityInterface;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Blog implements EntityInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Author author;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comments;
    @NotNull
    private int likeCount;
    @NotNull
    private String message;
    private String title;

    public Blog(Author author, String title, String message) {
        this.author = author;
        this.title = title;
        this.likeCount = 0;
        this.message = message;
        this.comments = new ArrayList<>();
    }

    public Blog() {
        this.comments = new ArrayList<>();
        this.likeCount = 0;
    }

    public Object getId() {
        return id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComments(Comment... comments){
        this.comments.addAll(Arrays.asList(comments));
    }

    // Copies all the attributes from an blog object to this blog object
    public void cloneFrom(EntityInterface blogg) {
        Blog blog = (Blog) blogg;
        if (blog.getComments().size() != this.comments.size()) {
            Comment comment = blog.getComments().get(((Blog) blogg).getComments().size() - 1);
            comment.setAuthor(author);
            comments.add(comment);
        }
        this.likeCount = blog.likeCount;
        this.message = blog.message;
    }

    @Override
    public String toString() {
        return "\nBlog{" +
                "id=" + id +
                ", author=" + author +
                ", comments=" + comments +
                ", likeCount=" + likeCount +
                ", message='" + message + '\'' +
                "}\n";
    }
}
