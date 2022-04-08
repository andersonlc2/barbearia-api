package com.dotsystems.barb.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotsystems.barb.dtos.ServicoComandaDTO;
import com.dotsystems.barb.entities.ServicoComanda;
import com.dotsystems.barb.repositories.ComandaRepository;
import com.dotsystems.barb.repositories.ServicoComandaRepository;
import com.dotsystems.barb.repositories.ServicoRepository;

@Service
public class ServicoComandaService {

	@Autowired
	private ServicoComandaRepository repository;

	@Autowired
	private ServicoRepository servicoRepository;

	@Autowired
	private ComandaRepository comandaRepository;

	@Transactional
	public ServicoComandaDTO save(ServicoComandaDTO obj) {
		var servico = new ServicoComanda();
		servico.setComanda(comandaRepository.findById(obj.getComanda()).get());
		servico.setServico(servicoRepository.findById(obj.getServico()).get());
		BeanUtils.copyProperties(obj, servico);
		repository.save(servico);
		return new ServicoComandaDTO(servico);
	}

	@Transactional
	public ServicoComandaDTO save(Long id_comanda, ServicoComandaDTO obj) {
		var servico = new ServicoComanda();
		servico.setComanda(comandaRepository.findById(id_comanda).get());
		servico.setServico(servicoRepository.findById(obj.getServico()).get());
		BeanUtils.copyProperties(obj, servico);
		repository.save(servico);
		return new ServicoComandaDTO(servico);
	}

	@Transactional
	public ServicoComandaDTO update(Long id_comanda, Long id, ServicoComandaDTO obj) {
		var servicoList = comandaRepository.findById(id_comanda).get();
		for (ServicoComanda servico : servicoList.getServicos()) {
			if (servico.getServico().getId() == id) {
				servico.setQuantidade(obj.getQuantidade());
				servico.setValor(obj.getValor());
				repository.save(servico);
				return new ServicoComandaDTO(servico);

			}
		}

		return null;
	}

	@Transactional
	public ServicoComandaDTO update(Long id_comanda, ServicoComandaDTO obj) {
		var servicoList = comandaRepository.findById(id_comanda).get();
		for (ServicoComanda servico : servicoList.getServicos()) {
			if (servico.getServico().getId() == obj.getServico()) {
				servico.setQuantidade(obj.getQuantidade());
				servico.setValor(obj.getValor());
				repository.save(servico);
				return new ServicoComandaDTO(servico);

			}
		}

		return null;
	}

	@Transactional
	public void delete(Long id_comanda, Long id) {
		var listServicos = comandaRepository.findById(id_comanda).get().getServicos();
		for (ServicoComanda servico : listServicos) {
			if (servico.getServico().getId() == id) {
				repository.delete(servico);
			}
		}
	}

	public List<ServicoComandaDTO> findAll() {
		return repository.findAll().stream().map(x -> new ServicoComandaDTO(x)).collect(Collectors.toList());
	}

	public List<ServicoComandaDTO> findByComanda(Long id) {
		Set<ServicoComanda> list = comandaRepository.findById(id).get().getServicos();
		List<ServicoComandaDTO> listDto = list.stream().map(x -> new ServicoComandaDTO(x)).collect(Collectors.toList());
		return listDto;
	}

	public ServicoComandaDTO findByServicoComanda(Long id, Long id_servico) {
		Set<ServicoComanda> list = comandaRepository.findById(id).get().getServicos();
		for (ServicoComanda servico : list) {
			if (servico.getServico().getId() == id_servico) {
				return new ServicoComandaDTO(servico);
			}
		}
		return null;
	}

}
