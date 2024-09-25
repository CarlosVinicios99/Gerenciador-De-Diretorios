import React from 'react'
import Directory from '../models/Directory'
import './DirectoryContainer.css'

interface DirectoryProps {
  directory: Directory
  onSelect: () => void
}

const DirectoryContainer = ({directory, onSelect}: DirectoryProps) => {
  return (
    <>
      <div className='directory-container' onDoubleClick={onSelect} >
        <img src="../../public/images/icone-diretorio.webp" alt="ícone de diretório" className='directory-icon' />
        <span>{directory.name}</span>
      </div>
      <hr className='separator-line'/>
    </>
  )
}
export default DirectoryContainer