import File from '../models/File';
import Directory from '../models/Directory';
import './FileSystemWindow.css'
import DirectoryContainer from './DirectoryContainer';
import FileContainer from './FileContainer'
import { useEffect, useState } from 'react';
import DirectoriesService from '../services/directories.service';
import FilesService from '../services/files.service';


const FileSystemWindow = () => {

    const [files, setFiles] = useState<File[]>([])

    const [directories, setDirectories] = useState<Directory[]>([])

    const [selectedDirectory, setSelectedDirectory] = useState<Directory>()

    const directoriesService: DirectoriesService = new DirectoriesService();
    const filesService: FilesService = new FilesService();

    //useEffect para obter o diretório raiz
    useEffect(() => {
        const findRootDirectory = async() => {
            const rootDirectory: Directory = await directoriesService.findRootDirectory()
            setSelectedDirectory(rootDirectory)
        }
        findRootDirectory()
    }, [])

    //useEffect para buscar o conteúdo do diretório selecionado e alterar o array de files e diretórios
    useEffect(() => {
        const findSubdirectoriesByDirectory = async() => {
            const subdirectories: Directory[] = 
                await directoriesService.findSubdirectoriesByDirectory(selectedDirectory?.directoryId || "")
            setDirectories(subdirectories)

            const files: File[] = await filesService.findFilesByDirectoryId(selectedDirectory?.directoryId || "")
            setFiles(files)
        }
        findSubdirectoriesByDirectory()
    }, [selectedDirectory])

    return (
        <div className="file-system-window-container">
            {
                
            }
            {/* 
            <DirectoryContainer key={1} directory={{name: "Vídeos", directoryId: "1"}}/>
            <DirectoryContainer key={2} directory={{name: "Documentos", directoryId: "2"}}/>
            <DirectoryContainer key={3} directory={{name: "Imagens", directoryId: "3"}}/>
            <FileContainer key={3} file={{fileId: "1", name: "arquivo1.txt", superDirectoryId: "4"}}/>
            <FileContainer key={3} file={{fileId: "2", name: "arquivo2.txt", superDirectoryId: "5"}}/>
            
            */}
        </div>
    )

}
export default FileSystemWindow;