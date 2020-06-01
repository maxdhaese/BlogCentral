package be.intecbrussel.listeners;

import be.intecbrussel.data.GenericMapper;
import be.intecbrussel.model.entities.Author;
import be.intecbrussel.model.entities.Blog;
import be.intecbrussel.model.entities.Comment;
import be.intecbrussel.tools.BCrypter;
import be.intecbrussel.tools.SessionController;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

public class Initialiser implements ServletContextListener {

    // This code executes whenever the webapp is started (when cargo deploy)
    @Override
    public void contextInitialized(ServletContextEvent sce) {


        Author author1= new Author("elarrosa","regis","Evaleen","Larrosa","elarrosa0@shop-pro.jp","Glacier Hill",5352,"Barra",2385);
        Author author2= new Author("anaulty", "down2earth", "Audy", "Naulty", "anaulty@baidu.com", "Rowland", 1, "Orlando", 3714);
        Author author3=new Author("dmarck", "com2com", "Denis", "Marck", "dmark@dailymail.co.uk", "Fulton", 5, "Libertad", 3295);
        Author author4=new Author("bgutter", "heet0", "Bruno", "Gutter", "bgutter@multiply.com", "Utah", 817, "Yueyang", 2196);
        Author author5=new Author("cforshaw", "hpV", "Cyril", "Forshaw", "cforshawj@theatlantic.com", "Fair Oaks", 815, "Gent", 1928);
        Author author6=new Author("saldinea", "traffic", "Stefan", "Aldine", "saldinea@deliciousdays.com", "Lyons", 5, "Momignies", 1828);
        Author author7=new Author("hlatek", "hexon", "Harley", "Latek", "hlatek@census.gov", "Annamark", 658, "Brusells", 3743);

        List<Author> l = new ArrayList<>();
        l.add(author1);
        l.add(author2);
        l.add(author3);
        l.add(author4);
        l.add(author5);
        l.add(author6);
        l.add(author7);
        l.forEach(e -> e.setPassword(BCrypter.hashPassword(e.getPassword())));


        Blog blog1=new Blog(author1,"The new way of writing for IRB-composed length scale parts","This is a hybrid way of incorporating both uniformity of output and the more general structure used in the Adler-Astrich (A-A) and LAB volumes in ARC ; these sections will be increased in resolution.");
        blog1.addComments(
        new Comment(author2,"How as a student should you proceed? Are you presenting a complete program or just the form of an A-A? One way to differentiate an A-A is to answer the following question: Does this structure have real structure? ")
        );

        Blog blog2=new Blog(author2,"What is artificial intelligence?"," The term 'artificial intelligence' generally means artificial thinking, and AI techniques are being employed for purposes of managing data and for organizing the world's data. ");
        blog2.addComments(new Comment(author6,"Why is there a need for research? I don't understand").addComments(new Comment(author2,"Advances in technology will enable computers to recognize objects, manipulate images and to think creatively about learning new problems. However, computing"),
        new Comment(author3,"In the age of computers, robots are not really going to destroy jobs in this country, and even if they do, they're not going to destroy them in the same way that cars and airlines did, where they displaced people.").addComments(new Comment(author2,"But there is more to it than that."))),
        new Comment(author2,"By 2025, the robot revolution will really be over. In fact, it will have played out in human society much more profoundly than we realized, and this is a huge story."));

        Blog blog3=new Blog(author5,"Java is the best programming language.","Computing data formats has undergone considerable research and development over the last decade.");
        Comment comment07=new Comment(author2,"I recently joined to a talk. The bulk of the talk was devoted to her role in developing Oracle JDK and Java development tools such as J2SE. These tools have drastically reduced development time and is responsible for the growth of the Java ecosystem.");
        Comment comment08=new Comment(author5,"They also discussed a number of other language challenges, including self-executing and argument-passing systems. The programmer should therefore turn to such techniques as return typing, encapsulation, and enums.");
        Comment comment09=new Comment(author7,"Unicode is more accurate, so it will always be the standard in most places. Even Python doesn't support unicode. (Well, Python 4 does, anyway.)");
        Comment comment10=new Comment(author5,"Java has been around for a long time and is still the second best language. You can use Java for medium-end to large-end applications with no problems.");

        Blog blog4=new Blog(author3,"Human employees are terrible","When human employees ask it to understand what they're saying, they quickly become alarmed when their colleagues don't know what they're trying to say, something many employers call 'computer illiteracy'");
        Comment comment11=new Comment(author1,"Allied forces must quickly mobilize and shape the information and multimedia content the community uses to contain the challenges of cyberwar, malware, cybercrime, and other cyberhazard information");
        Comment comment12=new Comment(author4,"We should be able to create an effective response that is timely, accurate, scalable, and resistant to manipulation.");
        Comment comment13=new Comment(author2,"To support our commitment, we will use our leadership platform to support the work of technical committees that assist in developing policies.");

        Blog blog5=new Blog(author7,"JPQL is better than SQL.","Although it is very common to fall back to SQL, it is not imperative.");
        Comment comment14=new Comment(author1,"But too many are NOT willing to learn about it because it is hard to implement efficiently");
        Comment comment15=new Comment(author2,"JPQL is better than SQL, which I used to do on my app when it was so poorly implemented that I could not know where to start. SQL is based on a few thousand rows of data,but should be succinct enough to actually do what you want without hurting the query.");
        Comment comment16=new Comment(author2,"In all reality, the advantage is there, but it has its limits, and doing extensive use of on-demand functions and filters sucks down memory and processor resources.");
        Comment comment17=new Comment(author4,"In the basic SQL Server database management suite, you are now required to perform two basic procedures - create, read and modify, and use in which situations. These procedures help you write and use a document library.");
        Comment comment18=new Comment(author4,"When you use these procedures, the data stored in your database is referred to as a schema. Your database is referred to as a database.");
        Comment comment19=new Comment(author6,"MangoDB is the best. Sorry.One of the main takeaways from using both MongoDB and StomAmbol is that there are a lot of ways to do a large number of queries and execute them simultaneously.");
        Comment comment20=new Comment(author7,"I also see some conflicts: the business logic that should never leave the database, cannot be replicated to the remote repository, nor can it be moved from a remote repository to an internal repository.");


        // End of instantiations of authors, blogs and comments

        // Creation of Mapper Objects
        GenericMapper<Blog> bm = new GenericMapper<>();
        GenericMapper<Author> au = new GenericMapper<>();
        GenericMapper<Comment> co = new GenericMapper<>();

        // Writing new entities to database
        au.addObject(author1);
        au.addObject(author2);
        au.addObject(author3);
        au.addObject(author4);
        au.addObject(author5);
        au.addObject(author6);
        au.addObject(author7);

        bm.addObject(blog1);
        bm.addObject(blog2);
        bm.addObject(blog3);
        bm.addObject(blog4);
        bm.addObject(blog5);

        // End. If the lines above are executed, the database will be full of data.
        SessionController.updateTotalRegisters(sce);
        SessionController.updateTotalVisits(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
