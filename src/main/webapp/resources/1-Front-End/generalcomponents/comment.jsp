<li class="comment">
  <div class="avatar">
    <a href="#">
      <img src="https://www.phplivesupport.com/pics/icons/avatars/public/avatar_53.png" alt="Eva photo avatar"
        class="avatar__img">
    </a>
  </div>
  <div class="comment__content">
    <div>
      <a href="author?username=${requestScope.comment.author.username}">
        <span class="user__link">${requestScope.comment.author.username}</span>
      </a>
      <span class="comment__pub-date"> - posted 1 week ago</span>
      <a href="#" title="report abuse" class="comment__action"><i
          class="fa fa-exclamation-triangle comment__action--report-abuse" aria-hidden="true"></i></a>
    </div>
    <p>
      ${requestScope.comment.message}
    </p>
    <footer class="comment__action--footer">
      <a href="#" title="like" class="comment__action">like</a>
      <a href="#" title="reply" class="comment__action">reply</a>
    </footer>
  </div>
  <ul class="comment__replies">
    <li class="comment">
      <div class="avatar">
        <a href="#">
          <img src="https://www.phplivesupport.com/pics/icons/avatars/public/avatar_53.png" alt="Eva photo avatar"
            class="avatar__img">
        </a>
      </div>
      <div class="comment__content">
        <div>
          <a href="#">
            <span class="user__link">Eva</span>
          </a>
          <span class="comment__pub-date"> - posted 1 week ago</span>
          <a href="#" title="report abuse" class="comment__action"><i
              class="fa fa-exclamation-triangle comment__action--report-abuse" aria-hidden="true"></i></a>
        </div>
        <p>
          Sed felis lorem, venenatis sed malesuada vitae, tempor vel turpis.
          Mauris in
          dui velit,
          vitae mollis
          risus.
        </p>
        <footer class="comment__action--footer">
          <a href="#" title="like" class="comment__action">like</a>
          <a href="#" title="reply" class="comment__action">reply</a>
        </footer>
      </div>
      <ul class="comment__replies">
        <li class="comment">
          <div class="avatar">
            <a href="#">
              <img src="https://www.phplivesupport.com/pics/icons/avatars/public/avatar_53.png" alt="Eva photo avatar"
                class="avatar__img">
            </a>
          </div>
          <div class="comment__content">
            <div>
              <a href="#">
                <span class="user__link">Eva</span>
              </a>
              <span class="comment__pub-date"> - posted 1 week ago</span>
              <a href="#" title="report abuse" class="comment__action"><i
                  class="fa fa-exclamation-triangle comment__action--report-abuse" aria-hidden="true"></i></a>
            </div>
            <p>
              Sed felis lorem, venenatis sed malesuada vitae, tempor vel turpis.
              Mauris in
              dui velit,
              vitae mollis
              risus.
            </p>
            <footer class="comment__action--footer">
              <a href="#" title="like" class="comment__action">like</a>
              <a href="#" title="reply" class="comment__action">reply</a>
            </footer>
          </div>

        </li>
      </ul>
    </li>

  </ul>
</li>