
	

function cadastrar()
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


function deletarEndereco()
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




function updateTable()
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


function createTable(){
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
	
	


createTable();