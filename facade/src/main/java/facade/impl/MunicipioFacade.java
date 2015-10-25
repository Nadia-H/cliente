package facade.impl;

import domain.Domain;
import domain.model.Municipio;
import domain.model.UFVO;
import facade.api.Facade;
import service.MunicipioService;
import service.impl.DefaultMunicipioService;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class MunicipioFacade {

    private MunicipioService service = new DefaultMunicipioService();

    public static Map<String, Object> toMap(Domain model) throws Exception {
        Map<String, Object> map = new LinkedHashMap<>();
        Municipio m = (Municipio) model;

        map.put(Facade.Municipio.KEY_ID, m.getId());
        map.put(Facade.Municipio.KEY_NOME, m.getNome());
        map.put(Facade.Municipio.KEY_UF, m.getUf());

        return map;
    }

    public void validar(CharSequence municipio, CharSequence uf) throws Exception {
        validar(null, municipio, uf);
    }

    public void validar(CharSequence id, CharSequence municipio, CharSequence uf) throws Exception {
        Municipio domain = new Municipio(municipio, uf);

        domain.setId(id == null || "".equals(id) ? null : Integer.valueOf(id.toString()));

        validar(domain);
    }

    public void validar(Domain municipio) throws Exception {
        service.validar((Municipio) municipio);
    }

    public void salvar(CharSequence municipio, CharSequence uf) throws Exception {
        salvar(null, municipio, uf);
    }

    public void salvar(CharSequence id, CharSequence municipio, CharSequence uf) throws Exception {
        Municipio domain = new Municipio(municipio, uf);

        domain.setId(id == null || "".equals(id) ? null : Integer.valueOf(id.toString()));

        salvar(domain);
    }

    public void salvar(Domain municipio) throws Exception {
        service.salvar((Municipio) municipio);
    }

    public void apagar(CharSequence id) throws Exception {
        apagar(Integer.valueOf(id.toString()));
    }

    public void apagar(Integer id) throws Exception {
        Municipio domain = new Municipio();

        domain.setId(id);

        apagar(domain);
    }

    public void apagar(Domain municipio) throws Exception {
        service.apagar((Municipio) municipio);
    }

    public Collection<? extends Domain> listar(Domain uf) throws Exception {
        return listar(uf.toString());
    }

    public Collection<? extends Domain> listar(CharSequence uf) throws Exception {
        // TODO Criar serviço para listar todos os municípios.
        return service.listar(UFVO.valueOf(uf));
    }
}
