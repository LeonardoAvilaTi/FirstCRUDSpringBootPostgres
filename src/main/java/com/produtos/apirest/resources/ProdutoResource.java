
package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API Rest Produtos")
@CrossOrigin(origins= "*")/*dominio que poderá acessar api*/

public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value= "Lista de todos Produtos cadastrados")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll(); 
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value= "Retoprna Produto conforme Id")
	public Produto listaProdutobyId(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	
	@PostMapping("/produto")
	@ApiOperation(value= "Salva Produto")
	public Produto Saveproduto(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
	

	@DeleteMapping("/produto")
	@ApiOperation(value= "Deleta Produto")
	public void DeleteProduto (@RequestBody Produto produto){
		produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value= "Atualiza Produto")
	public Produto UpdateProduto (@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}	
	
}