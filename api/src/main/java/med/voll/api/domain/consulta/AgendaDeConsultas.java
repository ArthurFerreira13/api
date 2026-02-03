package med.voll.api.domain.consulta;

import jakarta.validation.Valid;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.medico.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import med.voll.api.domain.medico.IMedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private IMedicoRepository medicoRepository;

    public void agendar(@Valid DadosAgendamentoConsulta dados){

        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do paciente não existe!");
        }
        if(dados.idMedico() !=null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do médico não existe");
        }

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);

        var consulta = new Consulta(null, medico, paciente, dados.data());
        repository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }
            if(dados.especialidade() == null){
                throw new ValidacaoException("Especialidade é obrigatória quando o médico não for selecionado!");
            }
            return medicoRepository.escolherMedicoAleatorioLivre(dados.especialidade(), dados.data());
    }

}
