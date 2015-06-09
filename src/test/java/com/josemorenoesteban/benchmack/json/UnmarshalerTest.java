package com.josemorenoesteban.benchmack.json;

import static com.josemorenoesteban.benchmack.json.Unmashaler.unmarshal;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnmarshalerTest {
    
    @Test public void testUnmarshal() throws URISyntaxException, IOException {
	final byte[] content = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("message_content.json").toURI()));
        Entity entity = unmarshal(content);
        
        assertEquals("53482190", entity.idExt);
        assertEquals("13310",    entity.id);
        assertEquals("6603",     entity.containerId);
        assertEquals("MODIFIED", entity.movement);
        assertNotNull(entity.coreAttribs);
        assertEquals(1,              entity.coreAttribs.length);
        assertNotNull(entity.coreAttribs[0].children);
        assertEquals(4,              entity.coreAttribs[0].children.length);
        assertEquals("ExternalCode", entity.coreAttribs[0].children[3].id);
        assertEquals("STRING",       entity.coreAttribs[0].children[3].type);
        assertEquals("53482190",     entity.coreAttribs[0].children[3].value);
    }
    
    @Test public void benchmarkUnmarshal() throws IOException, URISyntaxException { 
	final byte[] content    = Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("message_content.json").toURI()));
        final int    ITERATIONS = 100_000;

        Instant startInstant = Instant.now();
	for (int i=0; i < ITERATIONS; i++) {
            unmarshal(content);
	}
        Duration duration = Duration.between(startInstant, Instant.now());
        Duration perf     = Duration.ofNanos(duration.toNanos()/ITERATIONS);

        Logger.getAnonymousLogger().info( ()-> "Benchmark unmarshal\t\t" + ITERATIONS + "\t\t" + perf.toNanos() + " ns/op\n" );
        Logger.getAnonymousLogger().info( ()-> "ok\twpc.entity.Unmarshaller\t" + duration.getSeconds() + "s\n" );
    }
}
