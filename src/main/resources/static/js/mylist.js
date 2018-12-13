
/*function cadastrar()
{
	let xhr2 = new XMLHttpRequest();
	xhr2.open('POST', '/endereco');
	
	xhr2.onload = function(){

		if(this.status == 200){
			
	
			updateTable();

			

		}
	};
	
	xhr2.setRequestHeader('Content-Type', 'application/json');
	
	let novo_endereco = {"estado": document.getElementById("estado").value, 
			"cidade": document.getElementById("cidade").value, 
			"bairro": document.getElementById("bairro").value, 
			"rua": document.getElementById("rua").value, 
			"numero": document.getElementById("numero").value};
	
	
	xhr2.send(JSON.stringify(novo_endereco));
	

}

*/


let mei;
let endereco;
let servico;
let oferta;

function cadastrar()
{
	
	
	let novo_endereco = {"estado": document.getElementById("estado").value, 
			"cidade": document.getElementById("cidade").value, 
			"bairro": document.getElementById("bairro").value, 
			"rua": document.getElementById("rua").value, 
			"numero": document.getElementById("numero").value};
	
	
	
	fetch("/endereco",
	{
		
		
		method: "POST",
		headers: {
			"content-type": "application/JSON"
		},
		
		body: JSON.stringify(novo_endereco)
	}). then(function (response)
	{
	
		createTable();
		
	}).catch(function (error){
		
		console.log(error);
		
	});


}


/*function deletarEndereco()
{
	let xhr2 = new XMLHttpRequest();
	xhr2.open('DELETE', '/endereco/'+document.getElementById("end").value);
	
	xhr2.onload = function()
	{
		
		if(this.status == 200)
			{
			
			createTable()
			
			}
		
	};
	
	xhr2.send();

}
*/

function deletarEndereco()
{
	

	fetch("/endereco/"+document.getElementById("end").value,
	{
		
		
		method: "DELETE",
		
	}). then(function (response)
	{
	
		createTable();
		
	}).catch(function (error){
		
		console.log(error);
		
	});

	

}


/*function updateTable()
{
	let xhr2 = new XMLHttpRequest();
	xhr2.open('GET', '/endereco');
	
	xhr2.onload = function() {
		
		if(this.status == 200) {
			
			let r = JSON.parse(this.responseText);
			
				let tb = document.getElementById("enderecos");
				
				let p = r.content[r.content.length-1];
				console.log(r);

					tb.innerHTML +=  `<tr><th>${p.id}</th><th>${p.estado}</th><th>${p.cidade}</th><th>${p.bairro}</th><th>${p.rua}</th><th>${p.numero}</th></tr>`
				}
		
		
	}; 
		
	xhr2.send();



}

*/

/*function atualizarEndereco()
{
	
	let xhr2 = new XMLHttpRequest();
	xhr2.open('PUT', '/endereco/'+document.getElementById("endAt").value);
	
	xhr2.onload = function(){

		if(this.status == 200){
	
			document.getElementById("endAt").value = '';
	
			createTable();

			

		}
	};
	
	xhr2.setRequestHeader('Content-Type', 'application/json');
	
	let novo_endereco = {"estado": document.getElementById("estado2").value, 
			"cidade": document.getElementById("cidade2").value, 
			"bairro": document.getElementById("bairro2").value, 
			"rua": document.getElementById("rua2").value, 
			"numero": document.getElementById("numero2").value};
	
	
	xhr2.send(JSON.stringify(novo_endereco));
	
	
	
	novo_endereco = {"estado": document.getElementById("estado2").value = '', 
			"cidade": document.getElementById("cidade2").value = '', 
			"bairro": document.getElementById("bairro2").value = '', 
			"rua": document.getElementById("rua2").value = '', 
			"numero": document.getElementById("numero2").value = ''};
	





}
*/

/*function createTable(){
		let xhr2 = new XMLHttpRequest();
		xhr2.open('GET', '/endereco');
		
		xhr2.onload = function() {
			
			if(this.status == 200) {
				
					let r = JSON.parse(this.responseText);
					console.log(r);
					
					
					let tb = document.getElementById("enderecos");
					
					tb.innerHTML = ''
					for(let i=0; i<r.content.length; i++){
						let p = r.content[i];
						tb.innerHTML +=  `<tr><th>${p.id}</th><th>${p.estado}</th><th>${p.cidade}</th><th>${p.bairro}</th><th>${p.rua}</th><th>${p.numero}</th></tr>`
					}
			}
			
		}; 
			
		xhr2.send();
		
		
	}
*/



function atualizarEndereco()
{
	
	
	
	let novo_endereco = {"estado": document.getElementById("estado2").value, 
			"cidade": document.getElementById("cidade2").value, 
			"bairro": document.getElementById("bairro2").value, 
			"rua": document.getElementById("rua2").value, 
			"numero": document.getElementById("numero2").value};
	
	
	
	fetch("/endereco/"+document.getElementById("endAt").value,
	{
		
		
		method: "POST",
		headers: {
			"content-type": "application/JSON"
		},
		
		body: JSON.stringify(novo_endereco)
	}). then(function (response)
	{
	
		createTable();
		
	}).catch(function (error){
		
		console.log(error);
		
	});
	

}



function createTable(){
	
	fetch("/endereco")
		.then(function(response){
			
			if(response.status >= 200 && response.status <=300){
				
				response.json().then(function(data){
					
					let tb = document.getElementById("enderecos");
					
					tb.innerHTML = ''
					
					tb.innerHTML = "<tr><th>Id</th><th>Estado</th><th>Cidade</th><th>Bairro</th><th>Rua</th><th>Numero</th></tr>"
					
						for(let i =0; i<data.content.length; i++){
							let p = data.content[i];
							 tb.innerHTML +=  `<tr><th>${p.id}</th><th>${p.estado}</th><th>${p.cidade}</th><th>${p.bairro}</th><th>${p.rua}</th><th>${p.numero}</th></tr>`
						}
				})
				
			}
		
			
		
		}).catch(function(error){
			console.log(error);
		});
		
	
}
	








	
function cadastrarMei()
{
	let novo_mei = {"nome": document.getElementById("nome").value, 
			"telefone": document.getElementById("tel").value, 
			"cnpj": document.getElementById("cnpj").value, 
			"DescricaoPessoal": document.getElementById("descP").value, 
			"email": document.getElementById("email").value,
			"senha": document.getElementById("senha").value};
	
	
	
	fetch("/mei",
			{
				
				
				method: "POST",
				headers: {
					"content-type": "application/JSON"
				},
				
				body: JSON.stringify(novo_mei)
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
	
	
	let novo_servico = {"nome": document.getElementById("nomeS").value, 
			"descricao": document.getElementById("descS").value};
	
	
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
	
	let nova_oferta = {"preco": document.getElementById("preco").value, 
			"descrao": document.getElementById("disp").value};
	
	
	fetch("/oferta",
			{
				
				
				method: "POST",
				headers: {
					"content-type": "application/JSON"
				},
				
				body: JSON.stringify(nova_oferta)
			}). then(function (response)
			{
			
				
				

				if(response.status >= 200 && response.status <=300)
				{
				
				response.json().then(function(data){
				
					
				    oferta = data.id;
					
				  
					
					
				})
				
				
				}
				
				
				

				alert("Cadastro Feito com Sucesso !!");
				
				
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
				
					
				   
					linkarServico()
				  
					
					
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






//createTable();