<div class="card">
  
  <!-- CARD Left -->
  <div class="card-left">
    <% String username = request.getParameter("username"); %>
    <a class="card-left-title" href="author?username=<%=username%>"><%=request.getParameter("username")%></a>
    <i class="fa fa-user fa-lg"></i>
    <!-- <img src="https://switchfully.com/img/switchfully_small_logo.png"> -->
    <span>Some sub-text</span>
  </div>
  <!-- CARD-Right -->
  <div class="right">
    <fieldset>
      <legend>
        <% Integer id = Integer.parseInt(request.getParameter("id")); %>
        <h3><a class="card-title" href="blogdetail?id=<%=id%>"><%=request.getParameter("title")%></a>
        </h3>
      </legend>

      <p class=" card-message"><%=request.getParameter("message")%></p>
      <div class="card-icons">
        <a class="like-icon" title="Like" href="#">
          <i class="fa fa-thumbs-up"></i>
        </a>

        <span class="likes-count" title="Likes"><%=request.getParameter("likes")%></span>
        <a class="reply-icon" title="Comment" href="" onclick="alertFunction()"><i class="fa fa-comment"></i></a>
        <a class="tags-icon" title="Tags" href="" onclick="alertFunction()"><i class="fa fa-tags"></i></a>&nbsp;
        <a class="tags-icon" title="Bookmark" href="" onclick="alertFunction()"><i class="fa fa-bookmark"
            aria-hidden="true"></i></a>

      </div>
    </fieldset>

  </div>
</div>