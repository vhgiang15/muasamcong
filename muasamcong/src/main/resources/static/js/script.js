const mobileScreen = window.matchMedia("(max-width: 990px )");
$(document).ready(function () {
	
    $(".dashboard-nav-dropdown-toggle").click(function () {
        $(this).closest(".dashboard-nav-dropdown")
            .toggleClass("show")
            .find(".dashboard-nav-dropdown")
            .removeClass("show");
        $(this).parent()
            .siblings()
            .removeClass("show");
    });
    
    
    $(".menu-toggle").click(function () {
        if (mobileScreen.matches) {
            $(".dashboard-nav").toggleClass("mobile-show");
        } else {
            $(".dashboard").toggleClass("dashboard-compact");
        }
    });
    
    
});


function todayBidsNotice(obj)
{	    var page=obj.value;
                   $.ajax({
                    url : "/user/get-bidsnotice-today-bypage",
                    type : "get",
                    dataType:"text",
                    data : {page                     
                    },
                    success : function (result){
                        $('#result').html(result);
                    }
                });                                                                                 
}   
 
function searchBidsNotice(obj)
{	    var page=obj.value;
                   $.ajax({
                    url : "/user/get-bidsnotice-today-bypage",
                    type : "get",
                    dataType:"text",
                    data : {page                     
                    },
                    success : function (result){
                        $('#result').html(result);
                    }
                });                                                                                 
} 


  