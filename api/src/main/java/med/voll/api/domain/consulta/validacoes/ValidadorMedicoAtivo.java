package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.IMedicoRepository;

public class ValidadorMedicoAtivo {

    private IMedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        if(dados.idMedico() == null){
            return;
        }
        var meicoEstaAtivo = repository.findAtivoById(dados.idMedico());
    }

}
