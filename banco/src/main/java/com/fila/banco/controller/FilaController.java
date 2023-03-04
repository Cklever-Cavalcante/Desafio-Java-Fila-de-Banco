package com.fila.banco.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fila.banco.exception.ResourceNotFoundException;
import com.fila.banco.model.Clientes;
import com.fila.banco.repository.ClientesRepository;



@RestController
@RequestMapping("/api/v1/")
public class FilaController {

	@Autowired
	private ClientesRepository clientesRepository;

/*========================Metodos Listar============================================*/	
	
	// Listar todos os Clientes
		@GetMapping("/clientes")
		public List<Clientes> getAllClientes(){
			return clientesRepository.findAll();
		}		

/*=========================Metodos Criar============================================*/	
	
	// Criar novo Cliente rest api
		@PostMapping("/clientes")
		public Clientes createClientes(@RequestBody Clientes clientes) {
			return clientesRepository.save(clientes);
		}

/*==============================Metodos Listar pelo Id======================================================================*/	
		
	// Listar Cliente pelo id rest api
		@GetMapping("/clientes/{id_cliente}")
		public ResponseEntity<Clientes> getClientesById(@PathVariable Long id_cliente) {
			Clientes clientes = clientesRepository.findById(id_cliente)
					.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado :" + id_cliente));
			return ResponseEntity.ok(clientes);
		}
	
/*========================Metodos Atualizar=========================================*/	
		
	// Atualizar Cliente rest api
	
		@PutMapping("/clientes/{id_cliente}")
		public ResponseEntity<Clientes> updateClientes(@PathVariable Long id_cliente, @RequestBody Clientes clientesDetails){
			Clientes clientes = clientesRepository.findById(id_cliente)
					.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado :" + id_cliente));
			
			clientes.setNome(clientesDetails.getNome());
			clientes.setTelefone(clientesDetails.getTelefone());
			clientes.setIdade(clientesDetails.getIdade());
			clientes.setPosicaoNaFila(clientesDetails.getPosicaoNaFila());
			
			Clientes updatedClientes = clientesRepository.save(clientes);
			return ResponseEntity.ok(updatedClientes);
		}
	
/*=============================Metodos Deletar========================================================================*/	
		
	// Deletar Cliente rest api
		@DeleteMapping("/clientes/{id_cliente}")
		public ResponseEntity<Map<String, Boolean>> deleteClientes(@PathVariable Long id_cliente){
			Clientes clientes = clientesRepository.findById(id_cliente)
					.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado :" + id_cliente));
			
			clientesRepository.delete(clientes);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
	
}
