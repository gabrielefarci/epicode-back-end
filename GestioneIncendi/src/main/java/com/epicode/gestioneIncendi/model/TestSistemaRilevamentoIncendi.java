package com.epicode.gestioneIncendi.model;


import org.junit.Test;

import com.epicode.gestioneIncendi.interfaces.SondaInterface;

public class TestSistemaRilevamentoIncendi {
	
	@Test
    void testObserverPattern() {
        Sonda sonda = new Sonda();
        CentroDiControllo centro1 = new CentroDiControllo();
        CentroDiControllo centro2 = new CentroDiControllo();

        sonda.addObserver(centro1);
        sonda.addObserver(centro2);

        sonda.rilevaIncendio(6);

    }

    @Test
    void testProxyPattern() {
        SondaInterface sonda = SondaFactory.creaSonda(41.8781, -87.6298);
        sonda.rilevaFumo(7);

    }

}
