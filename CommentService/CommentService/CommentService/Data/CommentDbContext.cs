﻿using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace CommentService.Models
{
    public partial class CommentDBContext : DbContext
    {
        public CommentDBContext(DbContextOptions<CommentDBContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Comment> Comments { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Comment>(entity =>
            {
                entity.ToTable("comments");

                entity.HasIndex(e => e.EventId)
                    .HasName("IX_Comments_EventID");

                entity.HasIndex(e => e.UserId)
                    .HasName("IX_Comments_UserId");

                entity.Property(e => e.Id)
                    .HasColumnName("ID")
                    .HasColumnType("int(11)");

                entity.Property(e => e.EventId)
                    .HasColumnName("EventID")
                    .HasColumnType("int(11)");

                entity.Property(e => e.Message)
                    .IsRequired()
                    .HasColumnType("longtext")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.UserId).HasColumnType("int(11)");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
