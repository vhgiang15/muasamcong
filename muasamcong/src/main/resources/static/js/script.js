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
 

function searchBidsNotice()

{	    
	var noticeNo=$("#notice-no").val();
	var proCode=$("#procode").val();
	var dateFrom=$("#datefrom").val();
	var dateTo=$("#dateto").val();

                   $.ajax({
                    url : "/user/search-bidsnotice",
                    type : "get",
                    dataType:"text",
                    data : {noticeNo, proCode, dateFrom, dateTo                     
                    },
                    success : function (result){
                        $('#result-search').html(result);
                    }
                });                                                                                 
} 

function enablesearch()

{	    
	var provCode=$("#procode").val();
	if(provCode!=0)
	{
		$("#btn-search").removeClass('disabled');
	} else {
		$("#btn-search").addClass('disabled');		
	}                                                                               
} 

function checkday()

{	    
	var dateFrom=$("#datefrom").val();
	var dateTo=$("#dateto").val();
	var tmp1=dateFrom.substring(3,5)+"/"+dateFrom.substring(0,2)+"/"+dateFrom.substring(6,11)
	var tmp2=dateTo.substring(3,5)+"/"+dateTo.substring(0,2)+"/"+dateTo.substring(6,11)
	var startDay = new Date(tmp1);
	var endDay = new Date(tmp2);	
	var millisBetween = endDay.getTime() - startDay.getTime();
	var days = millisBetween / (1000 * 3600 * 24);	
	var diff=Math.round(Math.abs(days))+1;			
	if(diff<=30)
	{
		$("#btn-search").removeClass('disabled');
	} else {
		$("#btn-search").addClass('disabled');		
	}                                                                               
} 


  