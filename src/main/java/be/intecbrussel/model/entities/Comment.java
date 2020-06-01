package be.intecbrussel.model.entities;

import be.intecbrussel.model.EntityInterface;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Comment implements EntityInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Author author;
    @NotNull
    private String message;
    @NotNull
    private int likeCount;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comments;

    public Comment(Author author, String message) {
        this.author = author;
        this.message = message;
        this.likeCount = 0;
        this.comments = new ArrayList<>();
    }

    public Comment addComments(Comment... comments){
        this.comments.addAll(Arrays.asList(comments));
        return this;
    }

    public Comment(){
        this.likeCount = 0;
        this.comments = new ArrayList<>();
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Object getId() {
        return id;
    }

    // Copies all the attributes from an comment object to this comment object
    public void cloneFrom(EntityInterface commentt) {
        Comment comment = (Comment) commentt;
        this.message = comment.message;
        this.likeCount = comment.likeCount;
        comments.add(((Comment) commentt).getComments().get(((Comment) commentt).getComments().size() - 1));
    }

    @Override
    public String toString() {
        return "\n Comment{" +
                "id=" + id +
                ", author=" + author +
                ", message='" + message + '\'' +
                ", likeCount=" + likeCount +
                ", comments=" + comments +
                "}\n";
    }
}