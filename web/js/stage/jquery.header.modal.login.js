(function ($) {
    $.fn.extend({
        leanModal: function (options) {
            var defaults = {top: 100, overlay: 0.5, closeButton: null};
            var overlay = $("<div id='lean_overlay'></div>");
            $("body").append(overlay);
            options = $.extend(defaults, options);
            return this.each(function () {
                var o = options;
                $(this).click(function (e) {
                    var modal_id = $(this).attr("href");
                    $("#lean_overlay").click(function () {
                        close_modal(modal_id)
                    });
                    $(o.closeButton).click(function () {
                        close_modal(modal_id)
                    });
                    var modal_height = $(modal_id).outerHeight();
                    var modal_width = $(modal_id).outerWidth();
                    $("#lean_overlay").css({"display": "block", opacity: 0});
                    $("#lean_overlay").fadeTo(200, o.overlay);
                    $(modal_id).css({
                        "display": "block",
                        "position": "fixed",
                        "opacity": 0,
                        "z-index": 11000,
                        "left": 50 + "%",
                        "margin-left": -(modal_width / 2) + "px",
                        "top": o.top + "px"
                    });
                    $(modal_id).fadeTo(200, 1);
                    e.preventDefault()
                })
            });
            function close_modal(modal_id) {
                $("#lean_overlay").fadeOut(200);
                $(modal_id).css({"display": "none"})
            }
        }
    })
})(jQuery);

(function( $ ) {
    // constants
    var SHOW_CLASS = 'show',
        HIDE_CLASS = 'hide',
        ACTIVE_CLASS = 'active';

    $( '.tabs' ).on( 'click', 'li a', function(e){
        e.preventDefault();
        var $tab = $( this ),
            href = $tab.attr( 'href' );

        $( '.active' ).removeClass( ACTIVE_CLASS );
        $tab.addClass( ACTIVE_CLASS );

        $( '.show' )
            .removeClass( SHOW_CLASS )
            .addClass( HIDE_CLASS )
            .hide();

        $(href)
            .removeClass( HIDE_CLASS )
            .addClass( SHOW_CLASS )
            .hide()
            .fadeIn( 550 );
    });
})( jQuery );

$(function() {
    $("#registerEmail").blur(function () {
        $.ajax({
            type: "post",
            url: "emailAvailable.action",
            data: {userEmail: $("#registerEmail").val()},
            dataType: "text", //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
            success: function (data) {
                json = eval("(" + data + ")");
                if (json.result == "true") {
                    $("#div_show").text("该邮箱已注册");
                    $("#registerEmail").css({
                        "outline": "none",
                        "border-color": "#E86455",
                        "-webkit-box-shadow": "inset 0 1px 2px rgba(0, 0, 0, 0.15), 0 0 7px #E86455",
                        "-moz-box-shadow": "inset 0 1px 2px rgba(0, 0, 0, 0.15), 0 0 7px #E86455",
                        "box-shadow": "inset 0 1px 2px rgba(0, 0, 0, 0.15), 0 0 7px #E86455"
                    });
                }
            }
        });
    });
    $("#registerEmail").focus(function (){
        $("#div_show").text(" ");
        $("#registerEmail").css({
            "outline": "none",
            "color": "#525864",
            "border-color": "#84c0ee",
            "-webkit-box-shadow": "inset 0 1px 2px rgba(0, 0, 0, 0.15), 0 0 7px #96c7ec",
            "-moz-box-shadow": "inset 0 1px 2px rgba(0, 0, 0, 0.15), 0 0 7px #96c7ec",
            "box-shadow": "inset 0 1px 2px rgba(0, 0, 0, 0.15), 0 0 7px #96c7ec"
        });
    });
    $("#registerName").blur(function (){
        $.ajax({
            type: "post",
            url: "nameAvailable.action",
            data: {userName: $("#registerName").val()},
            dataType: "text",
            success: function (data) {
                json = eval("("+data+")");
                if (json.result == "true"){
                    $("#div_show").text("该用户名已注册");
                    $("#registerName").css({
                        "outline": "none",
                        "border-color": "#E86455",
                        "-webkit-box-shadow": "inset 0 1px 2px rgba(0, 0, 0, 0.15), 0 0 7px #E86455",
                        "-moz-box-shadow": "inset 0 1px 2px rgba(0, 0, 0, 0.15), 0 0 7px #E86455",
                        "box-shadow": "inset 0 1px 2px rgba(0, 0, 0, 0.15), 0 0 7px #E86455"
                    });
                }
            }
        });
    });
    $("#registerName").focus(function (){
        $("#div_show").text(" ");
        $("#registerEmail").css({
            "outline": "none",
            "color": "#525864",
            "border-color": "#84c0ee",
            "-webkit-box-shadow": "inset 0 1px 2px rgba(0, 0, 0, 0.15), 0 0 7px #96c7ec",
            "-moz-box-shadow": "inset 0 1px 2px rgba(0, 0, 0, 0.15), 0 0 7px #96c7ec",
            "box-shadow": "inset 0 1px 2px rgba(0, 0, 0, 0.15), 0 0 7px #96c7ec"
        });
    });
    $('#modaltrigger_login').leanModal({
        top: 110,
        overlay: 0.45,
        closeButton: ".hidemodal"
    });

    $('#modaltrigger_register').leanModal({
        top: 110,
        overlay: 0.45,
        closeButton: ".hidemodal"
    });

    $("#loginbtn").click(function () {
        $.ajax({
            type: "post",
            url: "login.action",
            data: {userEmail: $("#email").val(),
                   password: $("#password").val()},
            dataType: "text", //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
            success: function (data) {
                json = eval("(" + data + ")");
                if (json.result == "false") {
                    alert("登录失败：用户名或密码错误！");
                }
                if(json.result == "inverify"){
                    alert("登录失败：管理员还未审核！");
                }
                if(json.result == "true"){
                    window.location.href="/JavaEEPro/index.jsp";
                }
            }
        });
    });

    $("#registerbtn").click(function () {
        $.ajax({
            type: "post",
            url: "register.action",
            data: {userEmail: $("#registerEmail").val(),
                userPwd: $("#registerPassword").val(),
                userName: $("#registerName").val()
            },
            dataType: "text", //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
            success: function (data) {
                json = eval("(" + data + ")");
                if (json.result == "false") {
                    alert("注册失败，该用户已存在！");
                }
                if(json.result == "true"){
                    alert("注册成功，等待管理员审核！");
                }
            }
        });
    });
});

