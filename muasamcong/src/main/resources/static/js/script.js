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
	if(diff<=31)
	{
		$("#btn-search").removeClass('disabled');
	} else {
		$("#btn-search").addClass('disabled');		
	}                                                                               
} 

function getlink()

{	
	var link="/users/export/excel?provCode="+$("#provcode").val()+"&dateFrom="+$("#datefrom").val()+"&dateTo="+$("#dateto").val()+"&investFeild="+$("#investfield").val();
	checkdayreport();
	$("#link-search").attr("href", link);
	$("#linktest").text(link);
}

function checkdayreport()

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
	if(diff<=31)
	{
		$("#link-search").removeClass('disabled');
	} else {
		$("#link-search").addClass('disabled');		
	}                                                                               
} 


function reportdetail()

{	
	var provCode=$("#provcode").val();    
	var dateFrom=$("#datefrom").val();
	var dateTo=$("#dateto").val();
	var investFeild=$("#investfield").val();
	 $.ajax({
                    url : "/users/export/excel",
                    type : "get",
                    dataType:"text",
                    data : {provCode,dateFrom, dateTo,investFeild                     
                    },

                }); 	                                                                         
} 


function enablesearchkey()

{	    
	var typeInfo=$("#typeinfo").val();
	var key=$("#keysearch").val();
	
	if((typeInfo!=0)&&(key.length>3))
	{
		$("#btn-search-key").removeClass('disabled');
	} else {
		$("#btn-search-key").addClass('disabled');		
	}                                                                               
} 


function checkdayreportkey()

{	    
	var dateFrom=$("#datefromkey").val();
	var dateTo=$("#datetokey").val();
	var key=$("#keysearch").val();
	var tmp1=dateFrom.substring(3,5)+"/"+dateFrom.substring(0,2)+"/"+dateFrom.substring(6,11)
	var tmp2=dateTo.substring(3,5)+"/"+dateTo.substring(0,2)+"/"+dateTo.substring(6,11)
	var startDay = new Date(tmp1);
	var endDay = new Date(tmp2);	
	var millisBetween = endDay.getTime() - startDay.getTime();
	var days = millisBetween / (1000 * 3600 * 24);	
	var diff=Math.round(Math.abs(days))+1;			
	if(diff<=93)
	{
		$("#btn-search-key").removeClass('disabled');
	} else {
		$("#btn-search-key").addClass('disabled');		
	}                                                                               
} 


function reportkey()

{	
	var provCodeKey=$("#provcodekey").val();  
	var typeInfo=$("#typeinfo").val();  
	var key=$("#keysearch").val();
	var dateFrom=$("#datefromkey").val();
	var dateTo=$("#datetokey").val();
	var investFeild=$("#investfieldkey").val();
	$("#test").text("xin chào");
	 $.ajax({
                    url : "/user/export-report-key",
                    type : "get",
                    dataType:"text",
                    data : {provCodeKey,typeInfo,key,dateFrom, dateTo,investFeild                     
                    },

                }); 	                                                                         
} 

  