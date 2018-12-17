mostrarMei();

function mostrarMei(){
	
	
	id = localStorage.usuario;
	
	fetch("/mei/"+id)
		.then(function(response){
			
			
			
			if(response.status >= 200 && response.status <=300){
				
				response.json().then(function(data){
					
					console.log(data);
					
					document.getElementById("nome").value = data.nome;
					document.getElementById("email").value = data.email;
					document.getElementById("telefone").value = data.telefone;
					document.getElementById("cnpj").value = data.cnpj;



					
										
					
					
				})
				
			}
		
			
		
		}).catch(function(error){
			console.log(error);
		});
		
	
}

