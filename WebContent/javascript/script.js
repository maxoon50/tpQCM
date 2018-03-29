  $(document).ready(function(){
	  
    $('select').material_select();
    
    $('.modal').modal();
    
    $(document).on("click", ".test", function(e){
    	e.preventDefault();   	
    })
    
    $("#js-selection-theme").on('change', function(){
    	let id = $(this).val();
    	let nbreQuestionsMax = $("#js-nbre-questions-max").attr("data-"+id);
    	 $("#js-nbre-questions-max").attr("max", nbreQuestionsMax);
    })
    

  });
  
  
