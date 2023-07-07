package com.example.sd18_workshopmvcproject.services.project;


import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface ProjectService {

    boolean areImported();

    String getXMLContent() throws IOException;

    void importProjects() throws IOException, JAXBException;

    String exportFinishedProjects();
}
