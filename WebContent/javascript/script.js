

  $(document).ready(function(){
    $('select').material_select();
    $('.modal').modal();
    $(document).on("click", ".test", function(e){
    	e.preventDefault();   	
    })
    
	$( "#inscr-select-profil" ).change(function() {
		 console.log( "select candidat" );
		 console.log($("#inscr-select-profil").val());
		  
		  if ($("#inscr-select-profil").val()=='100'){
			    $("#cache-promo").removeClass("hide");
		  } else if($("#inscr-select-profil").val()=='101'){
			    $("#cache-promo").addClass("hide");
		  }
	});
    
    $("#inscr-select-promo").change(function(){
    	console.log($("#inscr-select-promo").val());
    	
    if ($("#inscr-select-promo").val()=='autre'){
    	$(".cache-new-promo").removeClass("hide");	
    } else if($("#inscr-select-promo").val()!='autre'&&!$(".cache-new-promo").hasClass("hide"))
    {
    	$(".cache-new-promo").addClass("hide");
  	}
    });
    
 
  
  });
  
  
 
