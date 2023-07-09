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


function getlinkreportkey()

{	    
	var typeInfo=$("#typeinfo").val();
	var key=$("#keysearch").val();
	
	if((typeInfo!=0)&&(key.length>3))
	{
		$("#link-search-key").removeClass('disabled');
	} else {
		$("#link-search-key").addClass('disabled');		
	}
	checkdayreportkey();
	var link="/user/export-report-key?provCodeKey="+$("#provcodekey").val()+"&typeInfo="+typeInfo+"&key="+key+"&dateFrom="+$("#datefromkey").val()+"&dateTo="+$("#datetokey").val()+"&investFeild="+$("#investfieldkey").val();
		$("#link-search-key").attr("href", link);
	                                                                               
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
		$("#link-search-key").removeClass('disabled');
	} else {
		$("#link-search-key").addClass('disabled');		
	}                                                                               
} 

function registerinfo()
	   {
	   var fullName=$("#fullname").val(); 
	   var user=$("#userform").val();
	   var phone=$("#phoneform").val();
	   var mail=$("#emailform").val();
	   $.ajax({
	            url : "/register-user",
	            type : "get",
	            dataType:"text",
	            data : {fullName,user,phone,mail                
	                    },
	            success : function (result){
	            $('#alert-register').html(result);
	                       }
	   }); 
	   } 
	   
	   
function resetPass()
{	
var email = $("#email").val();  
                    $.ajax({
                    url : "/reset-pass",
                    type : "get",
                    dataType:"text",
                    data : {email                 
                    },
                    success : function (result){
                        $('#alert-reset').html(result);
                    }
                });                                                                               
}

function trigger(obj){
     let regExpWeak = /[a-z]/;
     let regExpMedium = /\d+/;
     let regExpStrong = /.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/;
     let stringPass=obj.value;
     
     if(stringPass.length <= 3 && (stringPass.match(regExpWeak) || stringPass.match(regExpMedium) || stringPass.match(regExpStrong))) 
     {	$("#text").html("Mật khẩu yếu");
     	$("#btn-doipass").addClass("disabled");
     }
     if(stringPass.length >= 6 && ((stringPass.match(regExpWeak) && stringPass.match(regExpMedium)) || (stringPass.match(regExpMedium) && stringPass.match(regExpStrong)) || (stringPass.match(regExpWeak) && stringPass.match(regExpStrong))))
      {	$("#text").html("Mật khẩu trung bình");
      	$("#btn-doipass").removeClass("disabled");   
      }
     if(stringPass.length >= 6 && stringPass.match(regExpWeak) && stringPass.match(regExpMedium) && stringPass.match(regExpStrong))
     	{	$("#text").html("Mật khẩu mạnh");
     		$("#btn-doipass").removeClass("disabled");
     	}
}	


function changePass()
{
var oldPass=$("#oldpass").val();  
var newPass=$("#newpass").val(); 
var conPass=$("#conwpass").val(); 
$.ajax({
         url : "/SWP490JPA/change-pass",
         type : "get",
         dataType:"text",
         data : {oldPass,newPass,conPass                
                 },
         success : function (result){
         $('#alert').html(result);
                    }
}); 
}     
	   



  