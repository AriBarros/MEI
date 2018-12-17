function criarTabela(){
	
	fetch("/mei")
		.then(function(response){
			
			if(response.status >= 200 && response.status <=300){
				
				response.json().then(function(data){
					
					let tb = document.getElementById("usuarios");
					
					tb.innerHTML = ''
					
					tb.innerHTML = "<tr><th>Id</th><th>Nome</th><th>Email</th><th>Telefone</th></tr>"
					
						for(let i =0; i<data.content.length; i++){
							let p = data.content[i];
							 tb.innerHTML +=  `<tr><th>${p.id}</th><th>${p.nome}</th><th>${p.email}</th><th>${p.telefone}</th></tr>`
						}
				})
				
			}
		
			
		
		}).catch(function(error){
			console.log(error);
		});
		
	
}


function deletarMei()
{
	

	fetch("/mei/"+document.getElementById("numero").value,
	{
		
		
		method: "DELETE",
		
	}). then(function (response)
	{
	
		document.getElementById("numero").value = '';
		criarTabela();
		
	}).catch(function (error){
		
		console.log(error);
		
	});

	

}


function atualizar()
{
	
	
	
	let mei = {"nome": document.getElementById("nome").value, 
			"email": document.getElementById("email").value, 
			"telefone": document.getElementById("telefone").value};
	
	
	
	fetch("/mei/"+document.getElementById("numero_atualizar").value,
	{
		
		
		method: "PUT",
		headers: {
			"content-type": "application/JSON"
		},
		
		body: JSON.stringify(endereco1)
	}). then(function (response)
	{
	
		criarTabela();
		
	}).catch(function (error){
		
		console.log(error);
		
	});
	

}


criarTabela();
