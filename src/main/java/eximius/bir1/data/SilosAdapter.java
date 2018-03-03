package eximius.bir1.data;

import static eximius.bir1.Utils.isNull;

import java.util.stream.Stream;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class SilosAdapter extends XmlAdapter<Integer, Silos> {

    @Override
    public Integer marshal(final Silos silos) throws Exception {
        return silos.getId();
    }

    @Override
    public Silos unmarshal(final Integer silosId) throws Exception {
        if (isNull(silosId)) {
            return null;
        }
        return Stream.of(Silos.values())
                .filter(s -> s.getId() == silosId)
                .findAny()
                .orElse(null);
    }
}