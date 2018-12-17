let mei;
let endereco;
let servico;
let oferta;

	
function cadastrarMei()
{
	let novoMei = {"nome": document.getElementById("nome").value, 
			"telefone": document.getElementById("tel").value, 
			"cnpj": document.getElementById("cnpj").value,
			"email": document.getElementById("email").value,
			"senha": document.getElementById("senha").value};
	
	
	console.log(novoMei);
	
	
	fetch("/mei",
			{
				
				
				method: "POST",
				headers: {
					"content-type": "application/JSON"
				},
				
				body: JSON.stringify(novoMei)
			}). then(function (response)
			{
				
			
				if(response.status >= 200 && response.status <=300)
					{
					
					response.json().then(function(data){
					
						
					    mei = data.id;
						cadastrarEndereco();
						
						
						
					})
					
					
					}
				
				
			}).catch(function (error){
				
				console.log(error);
				
			});


}


function cadastrarEndereco()
{
	let novo_endereco = {"estado": document.getElementById("estado").value, 
			"cidade": document.getElementById("cidade").value, 
			"bairro": document.getElementById("bairro").value, 
			"rua": document.getElementById("rua").value, 
			"numero": document.getElementById("numero").value};
	
	
	console.log(novo_endereco);
	fetch("/endereco",
	{
		
		
		method: "POST",
		headers: {
			"content-type": "application/JSON"
		},
		
		body: JSON.stringify(novo_endereco)
	}). then(function (response)
	{
	
		

		if(response.status >= 200 && response.status <=300)
			{
			
			response.json().then(function(data){
			
				
			    endereco = data.id;
			    cadastrarServico();
				
				
				
				
			})
			
			
			}
		
		
	}).catch(function (error){
		
		console.log(error);
		
	});

} 


function cadastrarServico()
{
	
	let novo_servico = {"nome": document.getElementById("servico_nome").value, 
			"descricao": document.getElementById("servico_descricao").value 
			};
	
	
console.log(novo_servico.nome);	
	fetch("/servico",
	{
		
		
		method: "POST",
		headers: {
			"content-type": "application/JSON"
		},
		
		body: JSON.stringify(novo_servico)
	}). then(function (response)
	{
	
		

		if(response.status >= 200 && response.status <=300)
			{
			
			response.json().then(function(data){
			
				
			    servico = data.id;
			    cadastrarOferta();
				
				
				
				
			})
			
			
			}
		
		
	}).catch(function (error){
		
		console.log(error);
		
	});
	
	
}


function cadastrarOferta()
{
	
	let oferta1 = {"preco": document.getElementById("preco").value, 
			"disponibilidade": document.getElementById("disp").value};
	
	
	fetch("/oferta",
			{
				
				
				method: "POST",
				headers: {
					"content-type": "application/JSON"
				},
				
				body: JSON.stringify(oferta1)
			}). then(function (response)
			{
			
				
				

				if(response.status >= 200 && response.status <=300)
				{
				
				response.json().then(function(data){
				
					
				    oferta = data.id;
				    alert("Cadastro feito com sucesso!!");
				    
				    //lIMPAR CAMPOS
				    
				            document.getElementById("nome").value = '';
							document.getElementById("tel").value = ''; 
							document.getElementById("cnpj").value = '';
							document.getElementById("email").value = '';
							document.getElementById("senha").value = '';
				    
							document.getElementById("estado").value = ''; 
						    document.getElementById("cidade").value = ''; 
						    document.getElementById("bairro").value = ''; 
						    document.getElementById("rua").value = ''; 
						    document.getElementById("numero").value = '';
						    
						    document.getElementById("servico_nome").value = ''; 
							document.getElementById("servico_descricao").value = ''; 
							
							document.getElementById("preco").value = ''; 
							document.getElementById("disp").value = '';
						
				
							window.location.href = "http://localhost:8080/";
					
				  
					
					
				})
				
				
				}
				
				
				

			
				
				
			}).catch(function (error){
				
				console.log(error);
				
			});


}





function linkarEndereco()
{
	
	
	
	
	fetch("/mei/"+mei+"/"+endereco,
			{
				
				
				method: "PUT"
				
				

			}). then(function (response)
			{
			
				
				

				if(response.status >= 200 && response.status <=300)
				{
				
				response.json().then(function(data){
				
					
				   
					linkarServico();
				  
					
					
				})
				
				
				}
				
				
				
				
			}).catch(function (error){
				
				console.log(error);
				
			});


}


function linkarServico()
{
	
	
	
	
	fetch("/mei/servico"+mei+"/"+servico,
			{
				
				
				method: "PUT"
				
				

			}). then(function (response)
			{
			
				
				

				if(response.status >= 200 && response.status <=300)
				{
				
				response.json().then(function(data){
				
					
				   
					linkarOferta()
				  
					
					
				})
				
				
				}
				
				
				
				
			}).catch(function (error){
				
				console.log(error);
				
			});


}

function linkarOferta()
{
	
	
	
	
	fetch("/mei/oferta"+mei+"/"+oferta,
			{
				
				
				method: "PUT"
				
				

			}). then(function (response)
			{
			
				
				

				if(response.status >= 200 && response.status <=300)
				{
				
				response.json().then(function(data){
				
					
				   
					
					alert("Cadastro Feito com Sucesso !!");
					
					
				})
				
				
				}
				
				
				
				
			}).catch(function (error){
				
				console.log(error);
				
			});


}



function logar()
{
	
	let usuario = {"email": document.getElementById('userEmail').value, 
			"senha": document.getElementById('userSenha').value};
	
	
	
	if(usuario.email == "root" &&  usuario.senha == "root" )
	{
		window.location.href = "http://localhost:8080/index1.html";
	}
	
	
	
	
	fetch("/mei/log",
			{
				
				
				method: "POST",
				headers: {
					"content-type": "application/JSON"
				},
				
				body: JSON.stringify(usuario1)
			}). then(function (response)
			{
			
				
				
				response.json().then(function(data){
				
					
				    alert (""+data.id);
				
					
				})
				
			
				
			}).catch(function (error){
				
				console.log(error);
				
			});


}








