package br.com.fiap.checkpoint4.service;

import br.com.fiap.checkpoint4.dtos.*;
import br.com.fiap.checkpoint4.model.Cliente;
import br.com.fiap.checkpoint4.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponseDto createCliente(ClienteRequestCreateDto dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setBairro(dto.getEndereco());
        cliente.setCep(dto.getCep());

        Cliente savedCliente = clienteRepository.save(cliente);
        ClienteResponseDto responseDto = new ClienteResponseDto();
        responseDto.setId(savedCliente.getId());
        responseDto.setNome(savedCliente.getNome());
        responseDto.setEndereco(savedCliente.getBairro());
        responseDto.setCep(savedCliente.getCep());
        return responseDto;
    }

    public List<ClienteResponseDto> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(cliente -> {
            ClienteResponseDto dto = new ClienteResponseDto();
            dto.setId(cliente.getId());
            dto.setNome(cliente.getNome());
            dto.setEndereco(cliente.getBairro());
            dto.setCep(cliente.getCep());
            return dto;
        }).collect(Collectors.toList());
    }

    public ClienteResponseDto getClienteById(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            ClienteResponseDto dto = new ClienteResponseDto();
            dto.setId(cliente.getId());
            dto.setNome(cliente.getNome());
            dto.setEndereco(cliente.getBairro());
            dto.setCep(cliente.getCep());
            return dto;
        }
        return null;
    }

    public ClienteResponseDto updateCliente(Long id, ClienteRequestUpdateDto dto) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setNome(dto.getNome());
            cliente.setBairro(dto.getEndereco());
            cliente.setCep(dto.getCep());

            Cliente updatedCliente = clienteRepository.save(cliente);
            ClienteResponseDto responseDto = new ClienteResponseDto();
            responseDto.setId(updatedCliente.getId());
            responseDto.setNome(updatedCliente.getNome());
            responseDto.setEndereco(updatedCliente.getBairro());
            responseDto.setCep(updatedCliente.getCep());
            return responseDto;
        }
        return null;
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
