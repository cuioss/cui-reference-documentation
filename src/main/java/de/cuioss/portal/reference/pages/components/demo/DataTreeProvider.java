/*
 * Copyright © 2025 CUI-OpenSource-Software (info@cuioss.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.cuioss.portal.reference.pages.components.demo;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import java.io.Serial;
import java.io.Serializable;

@Named
@SessionScoped
@EqualsAndHashCode
@ToString
public class DataTreeProvider implements Serializable {

    @Serial
    private static final long serialVersionUID = 5441089632173462843L;

    public static final String DRIVE = "drive";

    public static final String FOLDER = "folder";

    public static final String FILE = "file";

    private transient TreeNode<String> root;

    private transient TreeNode<String> typedStructure;

    @Getter
    @Setter
    private boolean fullScreenFormActive;

    public String getDriveType() {
        return DRIVE;
    }

    public String getFolderType() {
        return FOLDER;
    }

    public String getFileType() {
        return FILE;
    }

    public String getFormStyle() {
        if (fullScreenFormActive) {
            return "full-screen-form";
        }
        return "";
    }

    public TreeNode<String> getRoot() {
        if (null == root) {
            root = initTree(true);
        }
        return root;
    }

    public TreeNode<String> getTypedStructure() {
        if (null == typedStructure) {
            typedStructure = initTree(false);
        }
        return typedStructure;
    }

    /**
     * Let simulate file explorer
     */
    private static TreeNode<String> initTree(boolean shouldUseDefaultType) {

        final TreeNode<String> structure = new DefaultTreeNode<>("Root", null);
        createDrive("C", structure, shouldUseDefaultType);
        createDrive("D", structure, shouldUseDefaultType);
        createDrive("E", structure, shouldUseDefaultType);
        return structure;

    }

    private static void createDrive(final String driverName, final TreeNode<String> parentNode,
        boolean shouldUseDefaultType) {
        final TreeNode<String> drive = new DefaultTreeNode<>(driverName, parentNode);
        if (!shouldUseDefaultType) {
            drive.setType(DRIVE);
        }

        final var programsFolder = createFolder("Programs", drive, shouldUseDefaultType);
        createFile("settings.xml", programsFolder, shouldUseDefaultType);
        createFile("readme.txt", programsFolder, shouldUseDefaultType);

        createFolder("Adobe", programsFolder, shouldUseDefaultType);

        final var oracleFolder = createFolder("Oracle", programsFolder, shouldUseDefaultType);
        createFolder("Java", oracleFolder, shouldUseDefaultType);
        createFile("readme.txt", oracleFolder, shouldUseDefaultType);

        createFolder("JetBrains", programsFolder, shouldUseDefaultType);
    }

    private static TreeNode<String> createFolder(final String folderName, final TreeNode<String> parent,
        boolean shouldUseDefaultType) {
        final var folder = new DefaultTreeNode<>(folderName, parent);
        if (!shouldUseDefaultType) {
            folder.setType(FOLDER);
        }
        return folder;
    }

    private static TreeNode<String> createFile(final String fileName, final TreeNode<String> parent,
        boolean shouldUseDefaultType) {
        final var fileNode = new DefaultTreeNode<>(fileName, parent);
        if (!shouldUseDefaultType) {
            fileNode.setType(FILE);
        }
        return fileNode;
    }
}
