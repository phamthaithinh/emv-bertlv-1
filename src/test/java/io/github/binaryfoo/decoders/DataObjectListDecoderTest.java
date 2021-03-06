package io.github.binaryfoo.decoders;

import io.github.binaryfoo.DecodedData;
import io.github.binaryfoo.EmvTags;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DataObjectListDecoderTest {

    @Test
    public void testDecode() throws Exception {
        String input = "9F02069F03069F090295055F2A029A039C019F37049F35019F45029F4C089F3403";
        DecodeSession session = new DecodeSession();
        session.setTagMetaData(EmvTags.METADATA);
        List<DecodedData> decoded = new DataObjectListDecoder().decode(input, 0, session);
        assertThat(decoded.size(), is(12));
        assertThat(decoded.get(0).getStartIndex(), is(0));
        assertThat(decoded.get(0).getEndIndex(), is(3));
        assertThat(decoded.get(1).getStartIndex(), is(3));
        assertThat(decoded.get(1).getEndIndex(), is(6));
        assertThat(decoded.get(11).getStartIndex(), is(30));
        assertThat(decoded.get(11).getEndIndex(), is(33));
    }

}
