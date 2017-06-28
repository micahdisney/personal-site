(function($) {
    request = $.ajax({
        'url': '/posts.json'
    });
    request.done(function (posts) {
        var html = '';
        ads.forEach(function(post) {
            html += '<div>';
            html += '<h1>' + post.title + '</h1>';
            html += '<p>' + post.description + '</p>';
            html += '<p>Published by ' + ad.author.username + '</p>';
            html += '</div>';
        });
        $('#posts').html(html);
    });
})(jQuery);