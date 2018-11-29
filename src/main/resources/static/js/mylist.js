
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
	
	


createTable();